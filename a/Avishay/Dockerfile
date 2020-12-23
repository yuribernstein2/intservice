FROM python:3.8
USER root
RUN pip3 install requests
RUN mkdir /Python_project
RUN chmod -R 755 /Python_project
COPY *.py /Python_project/
COPY configuration.json /Python_project/
WORKDIR "/Python_project"
RUN pwd
ENTRYPOINT ["/usr/local/bin/python3", "/Python_project/main.py"]

