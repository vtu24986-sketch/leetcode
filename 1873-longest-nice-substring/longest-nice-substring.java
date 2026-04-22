class Solution {
        public String longestNiceSubstring(String s) {
                return helper(s);
                    }

                        private String helper(String s) {
                                if (s.length() < 2) return "";

                                        for (int i = 0; i < s.length(); i++) {
                                                    char c = s.charAt(i);

                                                                if (s.indexOf(Character.toLowerCase(c)) == -1 ||
                                                                                s.indexOf(Character.toUpperCase(c)) == -1) {

                                                                                                String left = helper(s.substring(0, i));
                                                                                                                String right = helper(s.substring(i + 1));

                                                                                                                                return left.length() >= right.length() ? left : right;
                                                                                                                                            }
                                                                                                                                                    }

                                                                                                                                                            return s;
                                                                                                                                                                }
                                                                                                                                                                }
