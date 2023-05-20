import sys

SHOP = ['shop', 'flight', 'fares']
AIR = ['air', 'book', 'req']

def parse_shop(cmd: str):
    return cmd

def parse_seg(seg: list[str]):
    pass

def parse_air(cmd: str):
    if len(cmd[0]) > 3: return None
    if cmd[-1] != ['EOC']: return None
    for seg in cmd[1:-1]:
        if not parse_seg(seg): return None

def split(cmd: str) -> list[list]:
    return [l for line in cmd.split('\n') if (l:=line.strip().split())]

def parse(cmd: str) -> str:
    cmd = split(cmd)
    if len(cmd) and len(cmd[0]) >= 3:
        if cmd[0][:3] == SHOP: return parse_shop(cmd)
        elif cmd[0][:3] == AIR: return parse_air(cmd)
    return None

if __name__ == '__main__':
    string, file = None, None
    response = None

    if len(sys.argv) >= 3:
        # from command line string
        if sys.argv[1] == '-s':
            string = True
            response = parse(sys.argv[2])

        # from file
        elif sys.argv[1] == '-f':
            file = True
            with open(sys.argv[2], 'r') as fp:
                response = parse(fp.read())

    if not string or file:
        # from command line
        cmd = ' '.join(sys.argv[1:]) + '\n'
        if not cmd.strip(): 
            print('>', end=' ')
            cmd = input() + '\n'
        if cmd == ' '.join(AIR) + '\n':
            while not cmd.endswith('EOC\n'):
                print('>', end=' ')
                cmd += input() + '\n'
        response = parse(cmd)

    print(response)
