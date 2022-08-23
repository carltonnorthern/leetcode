class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<cpdomains.length; i++) {
            String cpdomain = cpdomains[i];
            String[] cpdomainSplit = cpdomain.split(" ");
            int rep = Integer.parseInt(cpdomainSplit[0]);
            String domain = cpdomainSplit[1];
            String[] domainSplit = domain.split("\\.");
            for(int j=0; j<domainSplit.length; j++){
                String subdomain = "";
                if(j==0) {
                    subdomain = domainSplit[0] + "." + domainSplit[1];
                    if(domainSplit.length == 3) {
                        subdomain = subdomain + "." + domainSplit[2];
                    }
                } else if(j==1) {
                    subdomain = domainSplit[1];
                    if(domainSplit.length == 3) {
                        subdomain = subdomain + "." + domainSplit[2];
                    }
                } else if(j==2) {
                    subdomain = domainSplit[2];
                } 
                
                if(map.containsKey(subdomain)) {
                    map.put(subdomain, map.get(subdomain) + rep);
                } else {
                    map.put(subdomain, rep);
                }
            }
        }
        
        List<String> result = new ArrayList<String>();
        for(String s : map.keySet()){
            result.add(String.valueOf(map.get(s)) + " " + s);
        }
        
        return result;
    }
}