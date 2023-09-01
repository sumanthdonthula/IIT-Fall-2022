Data=read.csv('A1_Q2_Data.csv',header=FALSE);
Y = Data[1]$V1
X = Data[2]$V2

plot(X,Y)
SXX = sum( X * X) - length(X) * (mean(X))^2
SXY = sum(X *Y ) - length(X) * mean(X) * mean(Y)
SYY = sum( Y * Y) - length(Y) * (mean(Y))^2
sum(X*X)-length(X) * mean(X) *mean(X)
mean(X)
sum(X*X)
length(X)*mean(X)*mean(X)

BETA1HAT = SXY / SXX
BETA0HAT = mean(Y) - BETA1HAT * mean(X)

# Y = BETA0HAT + BETA1HAT * X
# Y = 20517.59 - 170.57X

plot(X,Y)
abline(BETA0HAT,BETA1HAT,col=2,lwd=2)

Y_81= BETA0HAT + BETA1HAT * 81
Y_82= BETA0HAT + BETA1HAT * 82

DIFF= Y_82-Y_81

Y_80= BETA0HAT + BETA1HAT * 80



E10=(Y[10]-(BETA0HAT + BETA1HAT * X[10]))

RSS = SYY - BETA1HAT * SXY
SIGMASQUARE=RSS/(length(X)-2)
SIGMASQUARE


