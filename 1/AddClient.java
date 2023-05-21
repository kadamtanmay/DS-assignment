import java.rmi.Naming;

public class AddClient {
    public static void main(String args[]) {
        if (args.length < 3) {
            System.out.println("Usage: java AddClient <server_address> <num1> <num2>");
            return;
        }

        try {
            String addServerURL = "rmi://" + args[0] + "/AddServer";
            AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(addServerURL);
            double d1 = Double.parseDouble(args[1]);
            double d2 = Double.parseDouble(args[2]);
            System.out.println("The sum is: " + addServerIntf.add(d1, d2));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
