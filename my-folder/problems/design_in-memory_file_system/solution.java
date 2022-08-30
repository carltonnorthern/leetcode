class FileSystem {
    Dir root;
    
    class Dir {
        Map<String, String> files;
        Map<String, Dir> dirs;
        String name;
        
        public Dir(String name) {
            files = new HashMap();
            dirs = new HashMap();
            this.name = name;
        }
        
        public List<String> ls() {
            List<String> output = new ArrayList();
            for(String s : files.keySet()) {
                output.add(s);
            }
            for(String s : dirs.keySet()) {
                output.add(s);
            }
            Collections.sort(output);
            return output;
        }
    }

    public FileSystem() {
        root = new Dir("/");
    }
    
    public List<String> ls(String path) {
        if(path.equals("/")) {
            return root.ls();
        }
        String[] nodes = path.split("/");
        Dir d = root;
        for(int i=1; i<nodes.length; i++) {
            String s = nodes[i];
            if(d.dirs.containsKey(s)) {
                d = d.dirs.get(s);
            } else {
                List<String> result = new ArrayList();
                result.add(s);
                return result;
            }
        }
        return d.ls();
    }
    
    public void mkdir(String path) {
        String[] nodes = path.split("/");
        Dir d = root;
        for(int i=1; i<nodes.length; i++) {
            String s = nodes[i];
            if(!d.dirs.containsKey(s)) {
                d.dirs.put(s, new Dir(s));
                
            }
            d = d.dirs.get(s);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] nodes = filePath.split("/");
        Dir d = root;
        for(int i=1; i<nodes.length; i++) {
            String s = nodes[i];
            if(i<nodes.length-1 && !d.dirs.containsKey(s)) {
                d.dirs.put(s, new Dir(s));
                d = d.dirs.get(s);
            } else if(i<nodes.length-1 && d.dirs.containsKey(s)) {
                d = d.dirs.get(s);
            } else if(i==nodes.length-1 && !d.files.containsKey(s)) {
                d.files.put(s, content);
            } else if(i==nodes.length-1 && d.files.containsKey(s)) {
                d.files.put(s, d.files.get(s) + content);
            }
        }
    }
    
    public String readContentFromFile(String filePath) {
        String[] nodes = filePath.split("/");
        Dir d = root;
        for(int i=1; i<nodes.length; i++) {
            String s = nodes[i];
            if(i<nodes.length-1 && d.dirs.containsKey(s)) {
                d = d.dirs.get(s);
            } else if(i==nodes.length-1 && d.files.containsKey(s)) {
                return d.files.get(s);
            }
        }
        
        return "";
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */