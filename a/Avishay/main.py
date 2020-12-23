import json
import send
import argparse
from logs import logger


def load_config():
    with open('./configuration.json') as json_file:
        configs = json.load(json_file)
        key = configs['configuration']['key']
        host = configs['configuration']['host']
        return key, host


# spiderman
def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("-w", "--word", type=str, help="Word to get sentiment for", required=True)
    args = parser.parse_args()
    hero_name = args.word
    logger.info("Parameter Passed are " + str(args))
    key, host = load_config()
    send.send(key, host, hero_name)

main()
