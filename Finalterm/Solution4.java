/*
 * @Author: uyrance uyrance@hotmal.com
 * @Date: 2024-04-22 17:40:09
 * @LastEditors: uyrance uyrance@hotmal.com
 * @LastEditTime: 2024-04-22 17:40:53
 * @FilePath: \INFO6205\Finalterm\Solution4.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package Finalterm;

import java.util.*;

public class Solution4 {
    private Map<String, List<Integer>> wordIndices;

    public Solution4(String[] wordsDict) {
        wordIndices = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            wordIndices.putIfAbsent(wordsDict[i], new ArrayList<>());
            wordIndices.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indices1 = wordIndices.get(word1);
        List<Integer> indices2 = wordIndices.get(word2);
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0, j = 0; i < indices1.size() && j < indices2.size(); ) {
            int index1 = indices1.get(i), index2 = indices2.get(j);
            minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            if (index1 < index2) {
                i++;
            } else {
                j++;
            }
        }
        
        return minDistance;
    }

    public static void main(String[] args) {
        String[] wordDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        Solution4 wordDistance = new Solution4(wordDict);
        System.out.println(wordDistance.shortest("coding", "practice")); 
       
    }
}
