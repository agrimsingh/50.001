/**
*@agrim ALphabet Generator code for 4.5.8 
*/
public class AlphabetGenerator {
    public static char[] generateFrequencyAlphabet(int base, String[] trainingData) {
        if (base < 0) return null;
        int[] counts = new int[26];
        int total = 0;
        for (int i = 0; i < trainingData.length; ++i) {
            for (int j = 0; j < trainingData[i].length(); ++j) {
                int charOffset = (int)(trainingData[i].charAt(j)) - 'a';
                if (charOffset > -1 && charOffset < 26) {
                    counts[charOffset]++;
                    total++;
                }
            }
        }
        int[] cdf = new int[26];
        for (int i = 0; i < cdf.length; ++i) {
            cdf[i] = (i > 0 ? cdf[i - 1] : 0) + counts[i];
        }
        char[] output = new char[base];
        for (int i = 0; i < base; ++i) {
            for (int j = 0; j < cdf.length; ++j) {
                if (cdf[j] * base > i * total) {
                    output[i] = (char)((int)'a' + j);
                    break;
                }
            }
        }
        return output;
    }
}