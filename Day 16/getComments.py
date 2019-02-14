from tweepy import OAuthHandler
from tweepy import API
from tweepy import Cursor
from datetime import datetime, date, time, timedelta
from collections import Counter
import sys


consumer_key = 'euTdu9tkSGKoHLL0f9qZ0qwUy'
consumer_secret = '8CCDnU0KUDD7bDFW7XoJ9Klgc3GyxEDIOkjRx6efiFF10MkFhY'

access_token = '939919094-wtTpswhtdoDMb4fMe5QWooZ7Mouhx8H5hYHVjNb2'
access_token_secret = 'RcMu43XvLyTqLveeHLBqXNf6dnbp5322EoIeQqA9tIukT'

auth = OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_token_secret)
auth_api = API(auth)

account_list = ["Trafico_ZMG"]
if len(account_list) > 0:
  for target in account_list:
    print("Getting data for " + target)
    item = auth_api.get_user(target)
    print(item.name)
    print( item.screen_name)
    print(item.description)
    print(str(item.statuses_count))
    print(str(item.friends_count))
    print(str(item.followers_count))


#     auth = OAuthHandler(consumer_key, consumer_secret)
# auth.set_access_token(access_token, access_token_secret)
# auth_api = API(auth)

# account_list = ["jufut390"]
# if len(account_list) > 0:
#   for target in account_list:
#     print("Getting data for " + target)
#     item = auth_api.get_user(target)
#     print("name: " + item.name)
#     print("screen_name: " + item.screen_name)
#     print("description: " + item.description)
#     print("statuses_count: " + str(item.statuses_count))
#     print("friends_count: " + str(item.friends_count))
#     print("followers_count: " + str(item.followers_count))



