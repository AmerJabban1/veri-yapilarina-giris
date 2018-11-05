package bolum08;

public class Cozumler {
    
    // 1. Bir ayrik kume veri yapisinda toplam kac ayrik kume oldugunu bulan
    // fonksiyonu yaziniz.
    int toplamKume(DisjointSet set) {
        DisjointSet.Element elements[] = set.getElements();
        int counter = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].getParent() == elements[i].getData()) {
                counter++;
            }
        }
        return counter;
    }
}
