Data=read.table("AS33Data.txt", header = FALSE, sep = "") 
Y = Data$V1
X1 = Data$V2
X2=Data$V3


#The diagnostic aids show that firstly, there are no outliers and the distribution for each variable is normal. Additionally, looking at the correlation matrix, Y and X1 have significant positive correlation, Y and X2 are positively correlated, but less so than Y and X1 and there’s no corrleation between X1 and X2.
pairs(~Y+X1+X2)
colnames(Data)=c("Y","X1","X2")
cor(Data)

#The regression model yields the equation Y= 37.65 + 4.425X1 + 4.375X2. Holding the other variable constant, Increasing one unit of X1 leads to an increase in the brand liking degree by 4.425, and holding X1 constant, an one unit increase in X2 leads to an increase of the brand liking degreee of 4.375. Both X1 and X2 are significant as the P values for each variable are < 0.05.
Lmodel=lm(Y~X1+X2)
summary(Lmodel)
#Y=37.65+4.25X1+4.375X2

Lmodel$residual
#There are no outliers and errors are normally distributed.


boxplot(Lmodel$residual)

#Yresidual=37.65+4.25*X1+4.375*X2

Yhat=37.65+4.25*X1+4.375*X2

plot(Yhat,Lmodel$residual)
plot(X1,Lmodel$residual)
plot(X2,Lmodel$residual)
plot(X1*X2,Lmodel$residual)

plot(Lmodel)
qqnorm(Lmodel$residual)
+qqline(Lmodel$residual)

library(lmtest)

bptest(Lmodel)


Lmodel2=lm(Y~X1)

anova(Lmodel2,Lmodel)

#Q8

anova(Lmodel)
anova(Lmodel2)

Ssrx1_x2=1566.45+306.25-1566.45





