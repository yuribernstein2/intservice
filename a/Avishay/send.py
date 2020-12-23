import requests
from logs import logger

def send(key, host, hero_name):
    logger.info("Requested sentiment for " + hero_name)
    url = "https://superhero-search.p.rapidapi.com/"

    querystring = {"hero": hero_name}

    headers = {
        'x-rapidapi-key': key,
        'x-rapidapi-host': host
    }

    response = requests.request("GET", url, headers=headers, params=querystring)
    response = response.json()

    parse_hero_request(response)

    # print(response)
    # return response

def parse_hero_request(response):
    print("aaa " + response['name'])
    sh_name = response['name']
    biography = response['biography']
    print(biography['fullName'])
    sh_real_name = biography['fullName']
    place_of_birth =biography['placeOfBirth']
    # race
    # height
    # weight
    # eyecolor
    # haircolor
    # profession
    print(sh_name + ' (' + sh_real_name + ')' + ' was born in ' + place_of_birth )
#


