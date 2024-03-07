public class Main {
    static int[] self;
    public static void main(String[] args) {
        StringBuilder st = new StringBuilder();
        self = new int[10001];
        for (int i = 1; i <= 10000; i++) {
            int check = i;
            String num = String.valueOf(i);

            for (int j = 0; j < num.length(); j++) {
                check += num.charAt(j) - '0';
            }

            if (check <= 10000) {
                self[check] = 1;
            }
        }

        for (int i = 1; i < self.length; i++) {
            if(self[i] == 0) {
                st.append(i + "\n");
            }
        }

        System.out.println(st);
    }
}
