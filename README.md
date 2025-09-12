# Last Pencil

A simple Java project where I built a console-based pencil game. The application simulates a two-player game between a user and a bot, where players take turns removing pencils from the table until none remain. The twist is that the bot follows a winning strategy whenever possible.

The project was implemented in stages:

1. **Stage 1 - Empty the pencil case:**  
   Print a line of vertical bars representing pencils and a simple `"Your turn!"` message.

2. **Stage 2 - New rules:**  
   Ask the user how many pencils to start with and who will go first, then display the pencils and the starting player.

3. **Stage 3 - Working on the gameplay:**  
   Implement the turn-based game loop where players remove pencils until none are left.

4. **Stage 4 - Fair play:**  
   Add input validation and error handling:
    - Only numeric, positive pencil counts are valid.
    - Players may only take 1, 2, or 3 pencils per turn.
    - Players cannot take more pencils than remain on the table.  
      The game ends when the last pencil is taken, and the winner is declared.

5. **Stage 5 - The right strategy:**  
   Replace the second player with a bot that follows a winning strategy.
    - If the bot is in a winning position, it removes the exact number of pencils needed to force the user into a losing
      position.
    - If the bot is in a losing position, it takes a random number of pencils (1-3).  
      This ensures the bot plays optimally whenever possible.


## Demo

Here, the player Jack is the bot

<video width="1920" height="1080" align="center" src="https://github.com/user-attachments/assets/8f288ec7-7e8c-4bce-af92-937f594d8bd9"></video>

## Takeaway

This project helped me practice building interactive console applications with game logic. I learned how to validate user input, enforce rules, and manage turn-based gameplay using loops and conditions. The final stage introduced me to implementing simple algorithms, as I had to design a bot that could recognize winning and losing positions. It gave me a good balance of programming fundamentals and problem-solving with strategy.
