class Solution {
    public String generateTag(String caption) {
        StringBuilder sb = new StringBuilder();

        caption = caption.trim();
        if(caption.isEmpty())
        {
            return "#";
        }

        sb.append("#");

        String [] arr = caption.split("\\s+");
        sb.append(arr[0].toLowerCase());

        for(int i=1;i<arr.length;i++)
        {
            String temp = arr[i].toLowerCase();
            sb.append(Character.toUpperCase(temp.charAt(0))).append(temp.substring(1)); 
        }

        if(sb.length()>100)
        {
            return sb.substring(0,100);
        }

        return sb.toString();
    }
}