package may30;

import may30.huffman_encoder.pair;

public class huffman_decoder {

	 
	//functional problem gfg,changed for current package huffman encoder
	String decodeString(pair root, String encodedStr){
        // Code here
        String ans = "";
        pair curr = root;
        for (int i=0; i<encodedStr.length(); i++) {
            if (encodedStr.charAt(i) == '0')
                curr = curr.left;
            else
                curr = curr.right;
            if (curr.left==null && curr.right==null) {
                ans += curr.c;
                curr = root;
            }
        }
        return ans+'\0';
    }

}
