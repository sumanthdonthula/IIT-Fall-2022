Data=read.table("AS3Q1Data.txt", header = FALSE, sep = "") 
Y = Data$V1
X = Data$V2

plot(X,Y)

lm1=lm(Y~X)
lm1

resid(lm1)

library(MASS)
boxcox(Y~X)

boxcox(Y~X,seq(0,1,0.01))

Yroot=Y^0.5
lm2=lm(Yroot~X)
lm2
plot(X,Yroot)+abline(10.261,1.076,col=3)


res=lm$residuals
pred=lm$fitted.values
plot(lm2,which=c(1,2))










