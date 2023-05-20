import itertools as it
import pathlib

LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
DIGITS = '0123456789'

FILE = pathlib.Path(__file__).parent / 'airline_codes.txt'

with open(FILE) as fp:
  airline_codes = [line.strip() for line in fp.readlines()]

invalid_airlines = []
for airline in it.product(LETTERS + DIGITS, repeat=2):
    airline = f'{airline[0]}{airline[1]}'
    if airline not in airline_codes:
       invalid_airlines.append(airline)

print(invalid_airlines)