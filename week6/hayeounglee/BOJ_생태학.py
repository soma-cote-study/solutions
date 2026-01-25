tree_count = {}
total = 0

while True:
    try:
        line = input()
    except EOFError:
        break

    total += 1
    if line in tree_count:
        tree_count[line] += 1
    else:
        tree_count[line] = 1

for tree in sorted(tree_count.keys()):
    percentage = (tree_count[tree] / total) * 100
    print(f"{tree} {percentage:.4f}")
