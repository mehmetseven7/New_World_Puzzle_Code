import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Boolean flashLight = true;
        int p1 = 1;
        int p2 = 2;
        int p3 = 5;
        int p4 = 10;
        int sumOfTime=18;
        ArrayList<Integer> beginnigOfBridge = new ArrayList<>();
        ArrayList<Integer> endOfBridge = new ArrayList<>();

            while (beginnigOfBridge.isEmpty() && sumOfTime>17){
                if(sumOfTime>17 && beginnigOfBridge.isEmpty()){//Begginig or reset the puzzle if sumOfTime>17
                    sumOfTime = 0;
                    while (!endOfBridge.isEmpty()){
                        endOfBridge.remove(0);
                    }
                    beginnigOfBridge.add(p1);
                    beginnigOfBridge.add(p2);
                    beginnigOfBridge.add(p3);
                    beginnigOfBridge.add(p4);
                    flashLight = true;
                    while(!beginnigOfBridge.isEmpty()){
                        if(flashLight == true){//if flashlight is in the beginning two people crosses the Bridge
                            int value1 = (int)(Math.random()*beginnigOfBridge.size());
                            int compareSpeed1 = 0;
                            int compareSpeed2 = 0;

                            beginnigOfBridge.get(value1);
                            System.out.println(beginnigOfBridge.get(value1) + " mins cross the bridge.");
                            compareSpeed1 = beginnigOfBridge.get(value1);
                            endOfBridge.add(beginnigOfBridge.get(value1));
                            beginnigOfBridge.remove(value1);

                            int value3 = (int)(Math.random()*beginnigOfBridge.size());
                            System.out.println(beginnigOfBridge.get(value3) + " mins cross the bridge.");
                            compareSpeed2 = beginnigOfBridge.get(value3);
                            endOfBridge.add(beginnigOfBridge.get(value3));
                            beginnigOfBridge.remove(value3);
                            System.out.println("\n");

                            if(compareSpeed1>compareSpeed2) sumOfTime = sumOfTime + compareSpeed1;
                            else sumOfTime = sumOfTime + compareSpeed2;

                            flashLight = false;
                        }
                        //if flashligh is in the end of bridge 1 people turns back. And if there is nobody int the beginnig nobody turns back.
                        else if(!beginnigOfBridge.isEmpty() && flashLight == false) {
                            int value2 = (int)(Math.random()*endOfBridge.size());
                            System.out.println(endOfBridge.get(value2) + " mins turned back to beginning.");
                            System.out.println("\n");
                            sumOfTime = sumOfTime + endOfBridge.get(value2);
                            beginnigOfBridge.add(endOfBridge.get(value2));
                            endOfBridge.remove(value2);
                            flashLight = true;
                        }
                    }

                }
            }
        System.out.println(sumOfTime);
    }

}