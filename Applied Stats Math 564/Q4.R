Data=read.csv('A1_Q4_Data.csv',header=FALSE);
Y = Data[1]$V1
X = Data[2]$V2
N=length(X)
SIGMASQUARE=16

plot(X,Y)

B11=17

L1=(1/(2*pi*SIGMASQUARE)^0.5)^6 * exp((-1/(2*16))*sum((Y-B11*X)^2))

B12=18
L2=(1/(2*pi*SIGMASQUARE)^0.5)^6 * exp((-1/(2*16))*sum((Y-B12*X)^2))

B13=19
L3=(1/(2*pi*SIGMASQUARE)^0.5)^6 * exp((-1/(2*16))*sum((Y-B13*X)^2))

SXX = sum( X * X) - length(X) * (mean(X))^2
SXY = sum(X *Y ) - length(X) * mean(X) * mean(Y)

BETA1HAT = SXY / SXX
BETA1HAT
L4=(1/(2*pi*SIGMASQUARE)^0.5)^6 * exp((-1/(2*16))*sum((Y-BETA1HAT*X)^2))

Yo=seq(17, 19, by = 0.001)
rm(Yabs)
Yabs=c()
for (i in Yo)
{
  BETA1HATO=i
  Yabs=append(Yabs,(1/(2*pi*SIGMASQUARE)^0.5)^6 * exp((-1/(2*16))*sum((Y-BETA1HATO*X)^2)))
}

length(Yo)
length(Yabs)
plot(Yo,Yabs)

Yo[which(Yabs==max(Yabs))]

plot(Yo,Yabs, type = "b", pch = 16, 
     col = "blue", xlab = "x", ylab = "y")





