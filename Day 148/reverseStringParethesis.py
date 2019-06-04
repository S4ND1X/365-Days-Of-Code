#reverse parent
string = "(abc)d(efg)"
def reverseInParentheses(s):
    n = s.count('(')
    for i in range(n):
        if '(' in s:
            start = s.find('(')
            end = s.find(')')
            new = s[start+1:end][::-1]
            s = s.replace(s[start:end+1],new)
    return s

print(reverseInParentheses(string))
        

 

#How to find domain of email


import re
s = 'My name is Conrad, and blahblah@gmail.com is my email.'
def findEmailDomain(s):
    return (re.search("@[\w.]+", s)).group()

print(findEmailDomain(s))


