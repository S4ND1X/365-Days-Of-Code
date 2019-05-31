#?Import urlopen to acces to  the web
from urllib.request import urlopen as uReq
#?Library to parse information in html
from bs4 import BeautifulSoup as soup

#?Url destination
my_url = "https://es.wikipedia.org/wiki/Harry_Potter_(personaje)"

#?Open the url and closing it
uClient = uReq(my_url)

page_html = uClient.read() 

uClient.close()

#?Parsing the html
page_soup = soup(page_html,"html.parser")

#?Print the header from the page
page_soup.h1

#?Obtain the information box from wikipedia
info_box = page_soup.find_all("table",{"class":"infobox"})

#?Get the title from the infobox
title = page_soup.find("th",{"class": "media"})




