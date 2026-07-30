class Solution { 
    public int minimumPushes(String word) { 
        // arr[i] represents how many characters can fit in layer i
        // Each layer can hold exactly 8 characters (since keys 2 to 9 give 8 total keys)
        int arr[] = new int[4]; 
        arr[0] = 8; // 1st push layer (8 spots)
        arr[1] = 8; // 2nd push layer (8 spots)
        arr[2] = 8; // 3rd push layer (8 spots)
        arr[3] = 2; // 4th push layer (remaining 2 spots out of 26 max letters)

        int i = 0; 
        int n = word.length(); 
        int count = 0; 

        while (n > 0 && i < 4) { 
            if (arr[i] != 0) { 
                count += (i + 1); // layer 0 takes 1 push, layer 1 takes 2 pushes...
                arr[i]--; 
                n--; 
            } else { 
                i++; 
            } 
        } 
        return count; 
    } 
}
