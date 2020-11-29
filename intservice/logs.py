import logging

logging.basicConfig(level=logging.INFO, format='[%(filename)-s:%(lineno)-d] %(levelname)-s - %(message)s')
logger = logging.getLogger(__file__)
