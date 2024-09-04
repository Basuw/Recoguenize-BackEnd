FROM python:3.8.10

WORKDIR /python

EXPOSE 8000

RUN pip install 'fastapi>=0.111.0,<0.112.0'
RUN pip install uvicorn
RUN pip install numpy
RUN pip install scipy
RUN pip install requests


COPY . .

CMD ["uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8000"]
