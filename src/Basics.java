import java.util.Arrays;

public class Basics {
    public static void main(String[] args) {
        
        //Declare a list of 5 integers
        int[] nums;

        //At this point nums holds null
        // System.out.println(nums);       // --> nums not initialized error
        //Comment out line 8 to continue

        //initialize nums to hold 23, 85, 19, and 13
        int[] players = {23, 85, 19, 13};
        System.out.println(players);


        // How is the Array printed?      by the reference pointer

        // Why is it printed that way?    it is an object that holds said pointer



        // Use .length    NOTE: no parenthesis in  .length for arrays it is a public instance variable in the Array class.
        // It is different than the method "String".length()
        System.out.println("The players list has "+ players.length + " elements.");

        // Use a Loop to print each player number in the Array:
        //Fix the for loop header so that it properly loops through the players Array without getting a bounds error
        for (int i = 0; i < players.length; i += 1){
            System.out.println("Player at index " + i + " is #" + players[i]);
        }

        // Write a second loop to print the same list of players but backwards... last element -> first element
        for (int i = players.length-1; i <= 0; i--){
          System.out.println("Player at index " + i + " is # " + players[i]);
        }
        
        

        // Assign nums a new integer Array with 5 elements
        nums = new int[5];
        

        // At this point the nums points to an array of 5  zeros (default value for integers)
        // the loop below is called a "FOR EACH" loop.
        // It executes once for every single element of the Array
        // It does not keep track of the position or index
        for (int num : nums){
            System.out.println(num); 
        }
            
        
       

        // Set each element of nums to a random number between 1 and 50
        // (Use a loop to do it)
        for (int i = 0; i < nums.length; i++){
          nums[i] = (int) (Math.random()*50)+1;
        }

        for (int num : nums) {
          System.out.println(num);
        }
        // Arrays of Objects
        String[] names; // names currently holds null (it has not been initialized)
        

        // now initialize names to hold 3 different name objects
        names = new String[3];

        // now instantiate each String element by individually assigning each poistion a name.
        // Donald, Daisy, Daffy
        names[0] = "August";
        names[1] = "Lukas";
        names[2] = "Juliette";
        // print the array of names 
        System.out.println(Arrays.toString(names));
        

        // Create a second array called moreNames
        // moreNames should have space for 10 Strings
        String[] moreNames = new String[10];

        // Copy the 3 names from earlier to the new names array
        for (int i = 0; i < names.length; i++){
          moreNames[i] = names[i];
        }

        // Set the 4th name in moreNames to Scrooge
        moreNames[3] = "Adam";
        moreNames[4] = "Kodyn";
        moreNames[5] = "Maddie";
        moreNames[6] = "Maddie";
        moreNames[7] = "Maddie";
        moreNames[8] = "Maddie";
        moreNames[9] = "Maddie";
        System.out.println(Arrays.toString(moreNames));
    }

}
