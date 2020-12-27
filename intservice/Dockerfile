FROM python:3
USER root
RUN mkdir /intservice
EXPOSE 5000
RUN chmod -R 755 /intservice
COPY * /intservice/
RUN pip3 install -r /intservice/requirements.txt
WORKDIR "/intservice"
ENV FLASK_APP=int.py
ENTRYPOINT ["/usr/local/bin/flask", "run"]
#ENTRYPOINT ["/usr/local/bin/python3", "/intservice/main.py"]