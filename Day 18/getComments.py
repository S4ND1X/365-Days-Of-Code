from tweepy import OAuthHandler
from tweepy import API
from tweepy import Cursor
from datetime import datetime, date, time, timedelta
from collections import Counter
import sys
import tweepy

consumer_key = 'UP4MwbLKrDclqSC3EpkRph6Pd'
consumer_secret = '1YokukdNJCi3VAM7qIOzSrBjOg06Lpjx2W3ehEjfrPeEQKW5Kj'
access_token = '939919094-PA76fcK91fIjoaN1LASGYdKlwkroN2TJWwIRiwbg'
access_token_secret = 'GqvN4ZR3O5aY4VEo37xugez8zUCn5kNTaMZUcuJuv0ZZy' 

auth = OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_token_secret)
auth_api = API(auth)

account_list = ["jufut390"]

if len(account_list) > 0:
  for target in account_list:
    print("Getting data for " + target)
    item = auth_api.get_user(target)  
    print("screen_name: " + item.screen_name) 

    
  #Get info about tweets
    end_date = datetime.utcnow() - timedelta(days=5)
    for status in Cursor(auth_api.user_timeline, id=target, tweet_mode = "extended").items():   
      #print tweets   
      if status.created_at < end_date:
        break
    
  
