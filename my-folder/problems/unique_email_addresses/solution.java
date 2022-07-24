class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<String>();
        for(String email : emails) {
            String[] splitAt = email.split("@");
            String[] splitPlus = splitAt[0].split("\\+");
            String procLocal = splitPlus[0].replace(".", "");
            String formEmail = procLocal + "@" + splitAt[1];
            uniqueEmails.add(formEmail);
        }
        return uniqueEmails.size();
    }
}