#origin = latitude and longitud
#destination = latitude and logitud 
#frequeny = How often scrap data
#duration = how long to scrap data
def gmaps_data(api_key, origin, destination, frequency, duration):

    site = 'https://maps.googleapis.com/maps/api/'

    #Use distancematrix service
    service = 'distancematrix/json'

    #input origin and destination from user
    locations = 'origins=%s&destinations=%s&departure_time=now&' % (origin, destination)

    #input api key
    key = 'key=%s' % (api_key)

    request_url = site + service + locations + key

    return request_url


