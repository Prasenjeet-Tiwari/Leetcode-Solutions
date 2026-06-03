import java.util.HashMap;

class Solution {

    public int[] arrayFiller(String s, int arr[]) {
        HashMap<Character, Integer> hm = new HashMap<>(); 

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (hm.containsKey(curr)) { 
                arr[i] = hm.get(curr);
            } else {
                hm.put(curr, i); 
                arr[i] = i;
            }
        }
        return arr;
    }

    public boolean CompareArrays(int arr1[], int arr2[]) {
        for (int i = 0; i < arr1.length; i++) { 
            if (arr1[i] != arr2[i]) { 
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr1 = new int[s.length()];
        int[] arr2 = new int[t.length()];

        arr1 = arrayFiller(s, arr1);
        arr2 = arrayFiller(t, arr2); 

        return CompareArrays(arr1, arr2);
    }
}
