def longestWord(text):
    abece  = "abcdefghijklmnopqrstvwxyABCDEFGHIJKLMNOPQRSTVWXYZ"
    text = text.replace(" ", ",")
    text = text.replace(",,",",")
    for i in text:
        if i not in abece and i != ",":
            text = text.replace(i,"")
    max = -1
    longestStr = ""
    for i in text.split(","):
        if len(i) > max:
            longestStr = i
            max = len(i)
    return longestStr
