import java.util.Scanner;

class sl2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ll l = new ll();

        for (int i = 1; i <= 100; i++) {
            l.insert(i);  
        }

        int choice;
        long currentPosition = 0;
        long diceRoll;

        do {
            System.out.println("1. Roll the dice \n2. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    
                    diceRoll = (long) (Math.random() * 6) + 1;
                    System.out.println("You rolled: " + diceRoll);

                    
                    currentPosition += diceRoll;

                    
                    if (currentPosition > 100) {
                        currentPosition = 100;
                    }

                
                    currentPosition = l.checkLadder(currentPosition);

                    
                    currentPosition = l.checkSnake(currentPosition);

                    
                    System.out.println("Your new position is: " + currentPosition);

                    
                    if (currentPosition == 100) {
                        System.out.println("Congratulations! You've reached position 100 and won the game!");
                        choice = 2;  
                    }
                    break;

                case 2:
                    System.out.println("Exiting the game. Thank you for playing!");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 2);
        sc.close();;
    }
}

class ll {

    class node {
        int data;
        node next;
        node prev;

        public node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    node first = null;
    node temp1 = null;


    public void insert(int i) {
        node n = new node(i);
        if (first == null) {
            first = n;
            temp1 = first;
        } else {
            node temp2 = first;
            while (temp2.next != null) {
                temp2 = temp2.next;
            }
            temp2.next = n;
            n.prev = temp2;
        }
    }

    
    public long checkLadder(long i) {
        

        
        while (temp1 != null && temp1.data != i) {
            temp1 = temp1.next;
        }

         
        if (temp1 != null) {
            switch ((int) i) {
                case 3:
                    while (temp1.data != 20) {
                        temp1 = temp1.next;
                    }
                    return temp1.data;

                case 6:
                    while (temp1.data != 34) {
                        temp1 = temp1.next;
                    }
                    return temp1.data;

                case 21:
                    while (temp1.data != 42) {
                        temp1 = temp1.next;
                    }
                    return temp1.data;

                case 28:
                    while (temp1.data != 75) {
                        temp1 = temp1.next;
                    }
                    return temp1.data;

                case 44:
                    while (temp1.data != 92) {
                        temp1 = temp1.next;
                    }
                    return temp1.data;

                case 50:
                    while (temp1.data != 72) {
                        temp1 = temp1.next;
                    }
                    return temp1.data;

                default:
                    return i;  
            }
        }


        return i;
    }

    
    public long checkSnake(long i) {
        
        node temp3 = null;  
        while (temp3 != null && temp3.data != i) {
            temp3 = temp3.next;
        }

 
        if (temp3 != null) {
            switch ((int) i) {
                case 98:
                    while (temp3.data != 4) {
                        temp3 = temp3.prev;
                    }
                    return temp3.data;

                case 97:
                    while (temp3.data != 7) {
                        temp3 = temp3.prev;
                    }
                    return temp3.data;

                case 96:
                    while (temp3.data != 8) {
                        temp3 = temp3.prev;
                    }
                    return temp3.data;

                case 95:
                    while (temp3.data != 10) {
                        temp3 = temp3.prev;
                    }
                    return temp3.data;

                case 60:
                    while (temp3.data != 15) {
                        temp3 = temp3.prev;
                    }
                    return temp3.data;

                case 51:
                    while (temp3.data != 1) {
                        temp3 = temp3.prev;
                    }
                    return temp3.data;

                default:
                    return i;  
            }
        }

        return i;
    }
}