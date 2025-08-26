package Collections;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String details;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String details) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.details = details;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", details='" + details + '\'' +
                '}';
    }
}

public class InsurancePolicyManagementSystem {
    private HashMap<String, Policy> policyMap = new HashMap<>();
    private LinkedHashMap<String, Policy> insertionOrderMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> expiryDateMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        insertionOrderMap.put(policy.policyNumber, policy);
        expiryDateMap.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringInNext30Days() {
        List<Policy> result = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate in30 = now.plusDays(30);
        for (Map.Entry<LocalDate, List<Policy>> entry : expiryDateMap.subMap(now, true, in30, true).entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;
    }

    public List<Policy> getPoliciesByHolder(String holder) {
        List<Policy> result = new ArrayList<>();
        for (Policy p : policyMap.values()) {
            if (p.policyholderName.equalsIgnoreCase(holder)) {
                result.add(p);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate now = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> it = policyMap.entrySet().iterator();
        while (it.hasNext()) {
            Policy p = it.next().getValue();
            if (p.expiryDate.isBefore(now)) {
                it.remove();
                insertionOrderMap.remove(p.policyNumber);
                List<Policy> list = expiryDateMap.get(p.expiryDate);
                if (list != null) {
                    list.remove(p);
                    if (list.isEmpty()) expiryDateMap.remove(p.expiryDate);
                }
            }
        }
    }

    // Demo main
    public static void main(String[] args) {
        InsurancePolicyManagementSystem sys = new InsurancePolicyManagementSystem();
        sys.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health"));
        sys.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Car"));
        sys.addPolicy(new Policy("P003", "Alice", LocalDate.now().plusDays(5), "Life"));
        sys.addPolicy(new Policy("P004", "Charlie", LocalDate.now().minusDays(1), "Travel"));

        System.out.println("Policy by number P001: " + sys.getPolicyByNumber("P001"));
        System.out.println("Policies expiring in next 30 days: " + sys.getPoliciesExpiringInNext30Days());
        System.out.println("Policies for Alice: " + sys.getPoliciesByHolder("Alice"));
        sys.removeExpiredPolicies();
        System.out.println("All policies after removing expired: " + sys.policyMap.values());
    }
}
