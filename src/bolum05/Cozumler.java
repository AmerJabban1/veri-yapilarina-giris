package bolum05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cozumler {
    
    // 4. Verilen bir ikili arama agacindaki sayilari buyukten kucuge ekrana yazan
    // fonksiyonu yaziniz.
    static void sirala(Tree tree) {
        tree.root.printPreOrder();
    }
    
    // 5. Verilen bir ikili arama agacindaki dolu dugum sayisini hesaplayan fonksiyonu
    // yaziniz. Bir dugumun hem sol hem sag cocugu varsa o dugume dolu dugum denir
    static int doluDugumSayisi(Node root) {
        if (root.left != null && root.right != null) {
            return 1 + doluDugumSayisi(root.left) + doluDugumSayisi(root.right);
        }
        return 0;
    }
    
    // 6. Verilen bir ikili arama agacindaki tek dugum sayisini hesaplayan fonksiyonu
    // yaziniz. Bir dugumun degeri tek sayiysa o dugume tek dugum denir.
    static int tekDugum(Node root) {
        if (root != null) {
            if (isOdd(root.data)) {
                return 1 + tekDugum(root.left) + tekDugum(root.right);
            } else
                return tekDugum(root.left) + tekDugum(root.right);
        }
        return 0;
    }
    
    // 7. Verilen bir ikili arama agacindaki yapraklardan rastgele bir tanesini dondu-
    // ren bir fonksiyonu yaziniz.
    static Node rasgeleYaprak(Node root) {
        if (root != null) {
            ArrayList<Integer> list = new ArrayList<>();
            getPostOrder(list, root);
            
            Node[] array = new Node[list.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = new Node(list.get(i));
            }
            
            Random random = new Random();
            int r = random.nextInt(array.length);
            return array[r];
        }
        return null;
    }
    
    // 8. Verilen bir ikili arama agacindaki dugumlerden, degeri X'ten kucuk olan-
    // larin sayisini donduren fonksiyonu yaziniz
    static int kucukX(Node root, int x) {
        if (root != null) {
            if (root.data < x) {
                return 1 + kucukX(root.left, x) + kucukX(root.right, x);
            } else {
                return kucukX(root.left, x) + kucukX(root.right, x);
            }
        }
        return 0;
    }
    
    // 9. Verilen bir ikili arama agacindaki tum yapraklari silen fonksiyonu yaziniz.    
    static void yapraklariSil(Node root) {
        if (root.left != null) {
            if (root.left.isLeaf()) {
                root.left = null;
            } else {
                yapraklariSil(root.left);
            }
        }
        if (root.right != null) {
            if (root.right.isLeaf()) {
                root.right = null;
            } else {
                yapraklariSil(root.right);
            }
        }
    }
    
    // 10. Verilen bir ikili arama agacindaki tum sayilarin toplamini bulan
    // fonksiyonu yaziniz.
    static int agacTopla(Node root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        getPostOrder(arrayList, root);
        
        int sum = 0;
        for (int n : arrayList) {
            sum += n;
        }
        return sum;
    }
    
    // 11. Verilen bir agacin ikili arama agaci kosullarini saglayip saglama-
    // digini bulan fonksiyonu yaziniz.
    static boolean kosulTamam(Node root) {
        if (root != null) {
            if (root.left != null) {
                if (root.data < root.left.data) {
                    return false;
                } else {
                    return kosulTamam(root.left);
                }
            }
            if (root.right != null) {
                if (root.data > root.right.data) {
                    return false;
                } else {
                    return kosulTamam(root.right);
                }
            }
            return true;
        }
        return false;
    }
    
    // 12. Verilen bir ikili arama agacinin tum dugumlerinin sol ve sag cocuklarinin
    // yerlerini degistiren fonksiyonu yaziniz.
    static void yerDegistir(Node root) {
        if (root.left != null && root.right != null) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
            yerDegistir(root.left);
            yerDegistir(root.right);
        }
    }
    
    // 13. Verilen bir ikili arama agacinin derinligini hesaplayan fonksiyonu yaziniz.
    static int derinlik(Node root) {
        if (root != null) {
            if (root.left != null || root.right != null) {
                return 1 + Math.max(derinlik(root.left), derinlik(root.right));
            }
        }
        return 0;
    }
    
    // 14. Verilen bir ikili arama agacindaki sayilar icerisinde k1 ile k2 arasinda
    // olanlari ekrana yazan fonksiyonu yaziniz.
    static void aralikYaz(Node root, int k1, int k2) {
        if (root != null) {
            if (root.left != null)
                aralikYaz(root.left, k1, k2);
            if (root.data > k1 && root.data < k2)
                System.out.print(root.data + " ");
            if (root.right != null)
                aralikYaz(root.right, k1, k2);
        }
    }
    
    // 15. Verilen bir ikili arama agacindaki tum dugumlerin toplam derinligini
    // hesaplayan fonksiyonu yaziniz.
    static int toplamDerinlik(Node root) {
        if (root != null) {
            return 1 + toplamDerinlik(root.left) + toplamDerinlik(root.right);
        }
        return 0;
    }
    
    static int size(Node root) {
        return root != null ? (1 + size(root.left) + size(root.right)) : 0;
    }
    
    private static void getPostOrder(List<Integer> list, Node root) {
        if (root != null) {
            list.add(root.data);
            getPostOrder(list, root.left);
            getPostOrder(list, root.right);
        }
    }
    
    private static boolean isOdd(int n) {
        return n % 2 == 1;
    }
}
