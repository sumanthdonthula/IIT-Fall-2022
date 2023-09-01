Data=read.csv('A1_Q1_Data.csv',header=FALSE);
Y = Data[1]$V1
X = Data[2]$V2

SXX = sum( X * X) - length(X) * (mean(X))^2
SXY = sum(X *Y ) - length(X) * mean(X) * mean(Y)
SYY = sum( Y * Y) - length(Y) * (mean(Y))^2


BETA1HAT = SXY / SXX
BETA0HAT = mean(Y) - BETA1HAT * mean(X)

# Y = BETA0HAT + BETA1HAT * X
# Y = 156.34 - 1.18X

plot(X,Y)
abline(BETA0HAT,BETA1HAT,col=2,lwd=2)

Y1= BETA0HAT + BETA1HAT * 50
Y2= BETA0HAT + BETA1HAT * 51

Y2-Y1

Y3= BETA0HAT + BETA1HAT * 60

RSS_8=(Y[8]-(BETA0HAT + BETA1HAT * X[8]))^2

RSS = SYY - BETA1HAT * SXY
SIGMASQUARE=RSS/(length(X)-2)
SIGMASQUARE
