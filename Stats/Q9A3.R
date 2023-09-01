Data=read.table("AS39Data.txt", header = FALSE, sep = "") 
Y = Data$V1
X1 = Data$V2
X2=Data$V3

Ylibrary(ggplot2)
ggplot(Data, aes(X1, Y, colour = as.factor(X2))) + geom_point()

plot(Y,X1+X2)

fit = lm(Y~X1+X2+X1*X2)
summary(fit)
fit$coef
anova(fit)

fit = lm(Y~X1)
anova(fit)


fit1 = update(fit,.~.+X2+X1*X2)
anova(fit1)
nrow(Data)

#From anova table

#SSR(X_2, X_1X_2|X_1) = SSR(X_2, X_1X_2, X_1) - SSR(X_1)
#=3670.9 + 453.1 + 113.0 - 3670.9

SSR=3670.9 + 453.1 + 113.0 - 3670.9

MSEf=909.1/60

DofF=3
DofP=1

Fstar=(SSR/(DofF-DofP))/(909.1/60)

qf(0.95,2,60)


#Fstar > F-ratio, therefore, we reject null hypothesis.

Y11=Y[X2==1]
Y12=Y[X2==0]
X11=X1[X2==1]
X10=X1[X2==0]

LinMod1=lm(Y11~X11)
LinMod2=lm(Y12~X10)

LinMod1
#Y=-50.884+1.668X
LinMod2
#Y=-126.905+2.776X

#Difference in the Model
#Y=76.021+1.102X

ggplot(Data, aes(x=X1, y=Y, col=as.factor(X2))) + geom_point() +
  geom_smooth(method="lm", se=FALSE)


