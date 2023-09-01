---
title: "Assn 02 Q1"
author: "Sumanth Donthula"
date: "2022-09-09"
output: pdf_document
---

Problem 2

Loading the file and assigning the Crime Rate as Y and Education Percentage in Counties as X


```{r}

Data=read.csv('A1_Q2_Data.csv',header=FALSE);
Y = Data[1]$V1
X = Data[2]$V2
```

Calculating SXX, SYY and SXY for Deriving values for Beta0 and Beta1 Estimators

```{r}
SXX = sum( X * X) - length(X) * (mean(X))^2
SXY = sum(X *Y ) - length(X) * mean(X) * mean(Y)
SYY = sum( Y * Y) - length(Y) * (mean(Y))^2
```

Calculating Beta1 and Beta0

```{r}
BETA1HAT = SXY / SXX
BETA0HAT = mean(Y) - BETA1HAT * mean(X)
```

1.a.

The Derived Linear Model is 
# Y = 20517.59 - 170.57X

Plotting the Crime Rate vs Education Percentage in County

The plot Supports Crime Rate Decreases with Education Percentage Linearly

```{r}
# Y = BETA0HAT + BETA1HAT * X
# Y = 156.34 - 1.18X

plot(X,Y,xlab="Education Percentage",ylab="Crime Rate")
abline(BETA0HAT,BETA1HAT,col=2,lwd=2)
```

1.b.

(1) Calculating a point estimate difference whose percentage Education is deferred by one percentage point which in turn resulted to be BETA1HAT

```{r}
Y_81= BETA0HAT + BETA1HAT * 81
Y_82= BETA0HAT + BETA1HAT * 82

Y_82-Y_81
```

(2) Point estimate of Women whose graduation percentage is 80

```{r}
Y_80= BETA0HAT + BETA1HAT * 80
Y_80
```

(3) Value of Error at 10th Data Point

```{r}
E10=Y[10]-(BETA0HAT + BETA1HAT * X[10])
```

(4) A Point Estimate of Variance

```{r}
RSS = SYY - BETA1HAT * SXY
SIGMASQUARE=RSS/(length(X)-2)
SIGMASQUARE
```
