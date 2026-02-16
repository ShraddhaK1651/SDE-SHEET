You have:
n cards arranged in a circular list.Each card has a color
You are given:
startIndex
targetColor
You can move:
Left (index - 1)
Right (index + 1)
Because it’s circular:From index 0, left → n-1 ,,From index n-1, right → 0
👉 Return the minimum number of moves required to reach ANY card having the target color.
