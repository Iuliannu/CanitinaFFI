public class C3_CodScurt {
    public static void main(String[] args) {

        Produs p = new Produs(
                "Zeamă de casă",
                24.50,
                30
        );

        String cod = p.getDenumire()
                .substring(0, 3)
                .toUpperCase()
                + (int) p.getPret();

        System.out.println("Cod scurt: " + cod);
    }
}