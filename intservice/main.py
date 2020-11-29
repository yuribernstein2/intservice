import json
import send
import argparse
from logs import logger

def load_config():
    with open('./configurations.json') as json_file:
        configs = json.load(json_file)
        key = configs['configurations']['key']
        host = configs['configurations']['host']
        return key, host

def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("-w", "--word", type=str, help="Word to get sentiment for", required=True)
    args = parser.parse_args()
    word = args.word
    logger.info("Parameters passed are " + str(args) )

    key = load_config()[0]
    host = load_config()[1]

    response = send.send(key, host, word)
    print(response)

main()
