package HW_L5_T1_Comparators;

import java.util.Comparator;

public class CustomDigitComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer lhs, Integer rhs) {
        if(lhs == null || rhs == null){
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        if((lhs % 2 == 0) && (rhs % 2 != 0)){
            return 1;
        } else if ((lhs % 2 != 0) && (rhs % 2 == 0)) {
            return -1;
        } else {
            return 0;
        }
    }
}
