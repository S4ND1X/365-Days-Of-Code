from tweepy import OAuthHandler
from tweepy import API
from tweepy import Cursor
from datetime import datetime, date, time, timedelta
from collections import Counter
import sys
import tweepy
import csv

consumer_key = 'UP4MwbLKrDclqSC3EpkRph6Pd'
consumer_secret = '1YokukdNJCi3VAM7qIOzSrBjOg06Lpjx2W3ehEjfrPeEQKW5Kj'
access_token = '939919094-PA76fcK91fIjoaN1LASGYdKlwkroN2TJWwIRiwbg'
access_token_secret = 'GqvN4ZR3O5aY4VEo37xugez8zUCn5kNTaMZUcuJuv0ZZy' 

auth = OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_token_secret)
api = tweepy.API(auth)

#!Open/create csv file
#! Enconding has to be in the csvFile
csvFile = open('tweets.csv','a', encoding='utf-8')
#!Use Csv Writer
csvWriter = csv.writer(csvFile)
#!Ask how many tweets do you want and who
user = input("User: ")
cant = int(input("Number Of Tweets: "))
#!Search the tweets in the user time line
userFeed = tweepy.Cursor(api.user_timeline, screen_name=user).items(cant)
#!Iterate trough the tweets
for tweets in userFeed:
#!Get individual tweet
  tweet = tweets.text 
  tweet = str(tweet)
  if "Activa" in tweet:
    #Get word index
    subIndex = tweet.index("Activa")
    #Print everything before the word
    cleanTweet = tweet[:subIndex:]    
    #Add clean tweets to csv file
    csvWriter.writerow([cleanTweet]) 
csvFile.close()
