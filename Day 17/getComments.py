from tweepy import OAuthHandler
from tweepy import API
from tweepy import Cursor
from datetime import datetime, date, time, timedelta
from collections import Counter
import sys

consumer_key='MxgQ3zlPeOmG1NmSoSjP02jiu'
consumer_secret='rnliVRBUE36PFA1GjbgKtDIajEtLOn1yNad4jhYQS1McBMYuCE '
access_token='939919094-spNabEkOe2EYLXAOohVRHyKWvjzHY5YxHzh5C69E'
access_token_secret='r6F2nOKSdxfTNF4syd6ZqkKCnpQwT40axYh3q16yV9azj'
 
auth = OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_token_secret)
auth_api = API(auth)

account_list = ['@jufut390']
if len(account_list) > 0:
  for target in account_list:
    print("Getting data for " + target)
    item = auth_api.get_user(target)
    # print("name: " + item.name)
    # print("screen_name: " + item.screen_name)
    # print("description: " + item.description)
    # print("statuses_count: " + str(item.statuses_count))
    # print("friends_count: " + str(item.friends_count))
    # print("followers_count: " + str(item.followers_count))
else:
    print("valiste verga perro")