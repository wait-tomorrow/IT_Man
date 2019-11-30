package by.ITMan.homework.Lesson5;

import java.util.Comparator;

public class CollectionUtils {

    @SuppressWarnings("unchecked")
    public static void mergeSort(Object[] a, Object[] t, int l, int r, Comparator comp) {
        if (l >= r) {
            return;
        }
        int m = l + (r - l) / 2;
        mergeSort(a, t, l, m, comp);
        mergeSort(a, t, m + 1, r, comp);

        {
            int i = l;
            int j = m + 1;
            int k = l;
            while (i <= m && j <= r) {
                while (i <= m && (comp.compare(a[i], a[j]) <= 0)) {
                    t[k++] = a[i++];
                }
                if (i <= m) {
                    while (j <= r && (comp.compare(a[j], a[i]) < 0)) {
                        t[k++] = a[j++];
                    }
                }
            }
            while (i <= m) {
                t[k++] = a[i++];
            }
            while (j <= r) {
                t[k++] = a[j++];
            }
        }
        if (r + 1 - l >= 0) {
            System.arraycopy(t, l, a, l, r + 1 - l);
        }
    }

}
