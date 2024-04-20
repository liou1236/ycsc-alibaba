<template>
    <div>
        <!-- 1.编辑面包屑导航 -->
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>用户管理</el-breadcrumb-item>
            <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>
        <!-- 2.定义卡片标签 -->
        <el-card class="box-card">
            <el-row :gutter="20">
                <el-col :span="9">
                    <!-- 2.1定义用户输入框 -->
                    <el-input placeholder="请输入内容" v-model="queryInfo.query" class="input-with-select" clearable
                        @clear="getUserList()">
                        <el-button slot="append" icon="el-icon-search" @click="getUserList()"></el-button>
                    </el-input>
                </el-col>
                <el-col :span="4">
                    <!-- 2.2定义新增用户按钮 -->
                    <el-button type="primary" @click="addUserDialogVisible = true">添加用户</el-button>
                </el-col>
                <!-- 定义表格数据
                    :data 表格的数据来源 发起ajax请求
                -->
                <el-table :data="userList" style="width: 100%" stripe border>
                    <el-table-column prop="username" label="用户名"></el-table-column>
                    <el-table-column prop="phone" label="电话"></el-table-column>
                    <el-table-column prop="email" label="邮箱"></el-table-column>
                    <el-table-column prop="status" label="状态">
                        <template slot-scope="scope">
                            <!-- scope封装的对象 获取行级元素 row属性实行 -->
                            <el-switch v-model="scope.row.status" @change="updateStatus(scope.row)" active-color="#13ce66"
                                inactive-color="#ff4949">
                            </el-switch>
                        </template>
                    </el-table-column>
                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <el-button type="primary" icon="el-icon-edit" size="samll"></el-button>
                            <el-button type="primary" icon="el-icon-delete" size="samll"
                                @click="deleteUser(scope.row)"></el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <!-- 
                    定义分页功能
                    1.@size-change 当页面条数变化的时候触发
                    2.@current-change 当页面改变的时候进行触发
                    3.:current-page 显示当前的页数
                    4.:page-sizes 显示页数的组数
                    5.:page-size 初始化条件下每页的条数
                    6.layout  显示分页的样式种类 全部显示
                    7.:total  数据的总数
                 -->
                <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                    :current-page="currentPage4" :page-sizes="[1, 10, 20, 40]" :page-size="queryInfo.pageSize"
                    layout="total, sizes, prev, pager, next, jumper" :total="total">
                </el-pagination>
            </el-row>
        </el-card>
        <!-- :visible.sync 控制对相框 是否展现 -->
        <el-dialog title="用户新增" :visible.sync="addUserDialogVisible" width="65%" @close="closeAddUserDialog">
            <el-form :model="addUserForm" :rules="rules" ref="addUserRuleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item label="用户名" prop="username">
                    <el-input v-model="addUserForm.username"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input v-model="addUserForm.password"></el-input>
                </el-form-item>
                <el-form-item label="确认密码" prop="password2">
                    <el-input v-model="addUserForm.password2"></el-input>
                </el-form-item>
                <el-form-item label="电话" prop="phone">
                    <el-input v-model="addUserForm.phone"></el-input>
                </el-form-item>
                <el-form-item label="邮箱" prop="email">
                    <el-input v-model="addUserForm.email"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addUserDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="addUserBtn">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script>
export default {
    data() {
        //自定义校验规则rule: 当前规则对象一般不用 value:当前校验的数据  callback:回调函数
        //校验邮箱规则
        const checkEmail = (rule, value, callback) => {
            const emailRege = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
            if (emailRege.test(value)) {
                //表示邮箱合法  正确返回 通过返回true   失败返回false
                return callback()  //自定义规则执行成功 之后后续操作
            }
            callback(new Error('请填写正确的邮箱地址'))
        }
        //校验手机号的规则
        const checkPhone = (rule, value, callback) => {
            //定义验证手机号的正则
            const phoneRege = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/
            if (phoneRege.test(value)) {
                return callback()
            }
            callback(new Error('请填写正确的手机号'))
        }
        //确认密码 判断与password是否相同
        const checkPassword = (rule, value, callback) => {
            if (value !== this.addUserForm.password) {
                return callback(new Error('2次密码不一致'))
            }
            //
            callback()
        }
        return {
            //定义分页查询对象
            queryInfo: {
                query: '',//用户查询的数据
                pageNum: 1,//默认第一页
                pageSize: 5 //每页五条
            },
            userList: [],//获取分页后的结果
            total: 0,     //总数
            addUserDialogVisible: false,
            //设定新增用户的对象
            addUserForm: {
                username: '',
                password: '',
                password2: '',
                phone: '',
                email: ''
            },
            rules: {
                username: [
                    { required: true, message: '请输入用户名', trigger: 'blur' },
                    { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
                ],
                password2: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' },
                    { validator: checkPassword, trigger: 'blur' }
                ],
                phone: [
                    { required: true, message: '请输入电话', trigger: 'blur' },
                    { min: 11, max: 11, message: '长度必须11个字符', trigger: 'blur' },
                    { validator: checkPhone, trigger: 'blur' }
                ],
                email: [
                    { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                    { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' },
                    { validator: checkEmail, trigger: 'blur' }
                ]
            }
        }
    },
    methods: {
        //1.动态获取userList数据
        async getUserList() {
            const { data: result } = await this.$http.get("/user/list", { params: this.queryInfo })
            if (result.status !== 200) return this.$message.error("获取列表失败")
            //为total属性赋值
            this.total = result.data.total
            this.userList = result.data.rows
        },
        //当页面条数变化的时候触发
        handleSizeChange(pageSize) {
            //查询的条件需要改变
            this.queryInfo.pageSize = pageSize
            //重新去查询数据
            this.getUserList()
        },
        //当页面改变的时候进行触发
        handleCurrentChange(pageNum) {
            this.queryInfo.pageNum = pageNum
            this.getUserList
        },
        async updateStatus(user) {
            // 获取用户的id/状态信息 发起restFul请求
            //this.$http.put("/user/status/"+user.id+"/"+user.status)
            //模板字符串的写`` 可以编辑多行 可以直接对象取值${key}
            //es6的高级写法
            const { data: result } = await this.$http.put(`/user/status/${user.id}/${user.status}`)
            if (result.status !== 200) return this.$message.error("更新操作失败")
            this.$message.success("更新操作成功")
        },
        //当对话框关闭时应该重置表单
        closeAddUserDialog() {
            this.$refs.addUserRuleForm.resetFields()
        },
        addUserBtn() {
            //对整个表单重新校验 1、获取表单对象 2、进行数据校验
            this.$refs.addUserRuleForm.validate(async valid => {
                if (!valid) return this.$message.error("请正确填写")
                //之后发起Ajax请求  实现用户新增
                const { data: result } = await this.$http.post("/user/addUser", this.addUserForm)
                if (result.status != 200) return this.$message.error("新增用户失败")
                this.$message.success("新增用户成功")
                //关闭对话框
                this.addUserDialogVisible = false
                //重新获取页面
                this.getUserList()
            })
        },
        async deleteUser(user) {
            //定义消息确认框  peomise对象
            const result = await this.$confirm('此操作将永久删除' + user.username + ',是否继续？', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).catch(error => error)
            //config 确认 取消 cancel
            if (result !== 'confirm') return this.$message.info('用户取消操作')

            //发起Ajax请求实现数据的删除
            const { data: resultDB } = await this.$http.delete('/user/' + user.id)
            if (resultDB.status !== 200) return this.$message.error("删除操作失败")
            this.$message.success("用户删除成功")
            //用户列表重新加载
            this.getUserList()
        }
    },
    //当页面加载完成之后 调用该函数
    mounted() {
        //获取userlist列表数据
        this.getUserList()
    }
}
</script>
<style lang="less" scoped></style>
