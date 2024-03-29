# SodaMachine

Built a Soda Vending Machine for a school lab and decided to add a nice little ASCII interface for it.
We were given a rough UML diagram and told that it was open-ended and to build from our experiences with vending machines. I am basing mine
off of vending machines from the 90's, where the names of the beverages were on the labels, but if you pushed the button it told you your
choice and how much it cost. I don't remember the refund button ever working properly, but they all had one. We were also instructed to
have an option to restock the machine, I believe strictly for verification of our knowledge of programming.

When you start it up, you have the option of four beverages: Coke, Dr Pepper, Sprite, and Mello Yello.
There is a typo for Mello Yello, but after I realized the error, I did not want to change it because
then I would have needed to change almost every line of the ASCII display. Because ASCII art
was just for fun, I decided against it.
 
 ![Image description](https://efrq9q.dm.files.1drv.com/y4mdspPkhg4a6yWdSUcVM4cCOY-wr_d2rNKrhlMfZC9qL1qfXqNJGY1IGCEeKClVngFta2v7hoOb0afnXJg4kTcmXpBKvLuOPZSyNKikSz3fQ2_96UfONjXS6GumK5PF194JzvmcXpZ8I1LO_Z2DZf9xF5bAgfD_8F38EKYSacT5S6atenZASKAfAtiGVUCTbcf411povWBQCsHaIK_NZyzJQ?width=846&height=226&cropmode=none)

The ASCII display tells you the input for the corresponding beverage or alternative choices, being 'Insert Coin', 'Refund', and 'Restock'.
 - If you choose a beverage but do not have enough money inserted, it will tell you your beverage choice and its price. 
 - If there is enough money inserted, it will state "VEND, <BEVERAGE_CHOICE> BELOW", return the coin count to $0, and remove a beverage
      from the machine.
 - When you attempt to purchase a beverage that is out of stock, it will state "OUT OF STOCK."
 - When you select 'Restock', it states "BEVERAGES RESTOCKED".
 - When you 'insert' money, the machine will not accept any currency that is not % 5 == 0, so no daggone pennies!
 
 Only major stipulation of use is you cannot use decimal places when inserting money, it MUST BE WHOLE NUMBERS. I will fix this in the
 near future.
