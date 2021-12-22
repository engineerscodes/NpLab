/**
 * 
 */
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
package CAT3;

/*
  1)DATAGRAM
  TCP/IP-style networking provides a serialized, predictable, reliable stream of packet data. 
  This is not without its cost, however. TCP includes algorithms for dealing with congestion control on crowded networks, 
  as well as pessimistic expectations about packet loss. 
  This leads to inefficient way to transport data.
  Clients and servers that communicate via a reliable channel, 
  such as a TCP socket, have a dedicated point-to-point channel between themselves. 
  To communicate, they establish a connection, transmit the data, and then close the connection.
  All data sent over the channel is received in the same order in which it was sent. This is guaranteed by the channel.
  In contrast, applications that communicate via datagrams send and receive completely independent packets of information. 
  These clients and servers do not have and do not need a dedicated point-to-point channel. 
  The delivery of datagrams to their destinations is not guaranteed. Nor is the order of their arrival.
  
  A datagram is an independent, self-contained message sent over the network whose arrival, arrival time, and content are not guaranteed.

  Datagrams plays a vital role as an alternative.
  Datagrams are bundles of information passed between machines.
  Once the datagram has been released to its intended target, there is no assurance that it will arrive or even 
  that someone will be there to catch it.
  Likewise, when the datagram is received, there is no assurance that it hasn’t been damaged in transit or that
  whoever sent it is still there to receive a response and it is crucial point to note.
  IMP NOTES TO LOOK
  1)https://stackoverflow.com/questions/9456977/image-sent-over-udp-damaged
  2)https://security.stackexchange.com/questions/155007/is-it-possible-to-successfully-send-a-spoofed-udp-header-with-a-completely-unrel
  3)https://security.stackexchange.com/questions/155082/how-realistic-is-it-to-spoof-a-specific-udp-ip-address
  
  
  READ THIS 
  

Removing ourselves from something like the internet where we are bound by what rules an ISP would use, 
a typical network would not be able to distinguish between false UDP and true UDP.

Think of UDP like a child yelling for their mom in a crowded supermarket. The child can yell and
mom might or might not hear, but the child is going to keep yelling since they don't know if mom heard it. 
As a parent, you'll be able to differentiate your child from someone else's, 
but there are times when some other kid sounds just like yours. 
You could easily mistaken the yell of one child for yours. 
Since you and are child are separated, you don't have a 'handshake' to establish the child and mother in one conversation, 
it's just noise.

Since UDP is effectively just putting data on wire, 
there is nothing stopping you from spoofing the traffic -- you won't get a response back,
 but you can make the application think Alice is doing the talking.

In a real world, you have multiple layers of stuff which could easily identify 
that you're trying to send spoofed traffic and just drop it before it leaves your network segment.
  
  
 * */
 