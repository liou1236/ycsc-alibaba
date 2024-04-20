package lessonPhaseOne.classPractice.day0804;


    public class TunnelPassingExample {

        public static void main(String[] args) {
            Tunnel tunnel = new Tunnel();

            for (int i = 1; i <= 10; i++) {
                Person person = new Person(i, tunnel);
                person.start();
            }
        }
    }

    class Tunnel {
        private int currentPerson = 1;

        public synchronized void pass(int personId) {
            while (personId != currentPerson) {
                try {
                    wait();
                    System.out.println("wait");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("Person " + personId + " passed the tunnel.");
            currentPerson++;
            notifyAll();

            if (currentPerson > 10) {
                System.out.println("All persons passed the tunnel.");
            }
        }
    }

    class Person extends Thread {
        private int personId;
        private Tunnel tunnel;

        public Person(int personId, Tunnel tunnel) {
            this.personId = personId;
            this.tunnel = tunnel;
        }

        @Override
        public void run() {
            tunnel.pass(personId);
        }
    }


