import http.client
from logs import logger

def send(key, host, message):
    logger.info("Requested sentiment for " + message)
    conn = http.client.HTTPSConnection("smirow-meanings-v1.p.rapidapi.com")
    payload = "sample=" + message + "&language=eng"

    headers = {
        'content-type': "application/x-www-form-urlencoded",
        'x-rapidapi-key': key,
        'x-rapidapi-host': host
    }

    conn.request("POST", "/api/v1/sentiment", payload, headers)

    res = conn.getresponse()
    data = res.read()
    return(data.decode("utf-8"))
